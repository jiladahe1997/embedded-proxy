const config = require('config')

console.log(config.Client.webpack.publicPat)
module.exports = {
  pages: {
    index: {
      entry: './pages/main.js'
    }
  },
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8081/',
        //pathRewrite: (path, req)=> {
          //return path.replace('/api','')
        //},
        onProxyReq: (proxyReq, req, res)=> {
          console.log(`代理${req.host}${req.path}到${proxyReq.getHeader('host')}${proxyReq.path}`)
        }
      }
    }
  },
  publicPath: config.Client.webpack.publicPath
}