var COS = require('cos-nodejs-sdk-v5');
const fsPromise= require('fs').promises
const path = require('path')

var cos = new COS({
    SecretId: process.argv[2],
    SecretKey: process.argv[3]
});

function getBucket() {
  return new Promise((resolve, reject) => {
    cos.getBucket({
      Bucket: 'embeddedproxy-1252616609',
      Region: 'ap-chengdu',
      Prefix: 'static/',
    },(err, data)=>{
      if(err) reject(err)
      resolve(data)
    })
  })
}

async function uploadAllFile() {
  const files = await findAllFilePath('./dist')
  await Promise.all(files.map(async file=>{
    return new Promise(async (resolve, reject)=>{cos.putObject({
        Bucket: 'embeddedproxy-1252616609',
        Region: 'ap-chengdu',
        Key: `static/${file.filePath.replace('dist/','')}`,
        Body: await fsPromise.readFile(file.filePath)
      },(err, data)=>{
        if(err) reject(err)
        resolve(data)
      })
    })
  }))
  void 0
}

async function findAllFilePath(nowPath) {
  const filePaths = await fsPromise.readdir(nowPath)
  let ret = []
  if(filePaths.length > 0){
    await Promise.all(filePaths.map(async filePath=>{
      if(filePath.indexOf('.') !== -1) {
        ret.push({
          filePath:path.join(nowPath,filePath).replace(/\\/g,'/'),
          fileName:filePath
        })
      }
      else {
        const subFilePaths = await findAllFilePath(path.join(nowPath,filePath).replace(/\\/g,'/'))
        ret = Array.prototype.concat(ret,subFilePaths)
      }
    }))
  }
  return ret
}

async function publish() {
  const exitFiles = await getBucket()
  await uploadAllFile()
  console.log(exitFiles);
}

publish()