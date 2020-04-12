const dayjs = require("dayjs")
const crypto = require("crypto")
const axios = require("axios")

const SecretId = process.argv[2]
const SecretKey = process.argv[3]
const serviceName = process.argv[4] === 'test' ? 'embeddedproxy-website-test' : 'embeddedproxy-website'

const baseParams = {
  Action: "RedeployClusterService",
  Timestamp: dayjs().unix(),
  Nonce: Math.random(),
  Region: "ap-guangzhou",
  SecretId,
  clusterId: "cls-5hx5fiwm",
  serviceName
}

function signatureCalc(params) {
  // 签名计算，参考https://cloud.tencent.com/document/product/215/1693
  //第一步
  const sorted = Object.keys(params).sort().map(v=>{
    return `${v}=${params[v]}`
  })

  //第二步
  const joined = sorted.join('&')

  //第三步
  const method = "GET"
  const host = "ccs.api.qcloud.com"
  const path = "/v2/index.php"
  const connected = `${method}${host}${path}?${joined}`

  //第四步
  const encryption = crypto.createHmac("sha1", SecretKey).update(connected).digest()
  const base64 = Buffer.from(encryption).toString('base64')
  return base64
}

async function send() {
  const params = {
    ...baseParams,
    Signature: signatureCalc(baseParams)
  }
  const res = await axios.get("https://ccs.api.qcloud.com/v2/index.php", {
    params
  })

  if(res.data.code !== 0) {
    throw new Error(res.data.message)
  }
}

send()