const config = require('config')
const path = require('path')

module.exports = {
  pages: {
    index: {
      entry: './pages/index/main.js'
    },
    admin:{
      entry: './pages/admin/main.js'
    }
  },
  lintOnSave: 'warning',
  devServer: {
    proxy: {
      '/api': {
        target: config.Vue_Cli.backend,
        //pathRewrite: (path, req)=> {
          //return path.replace('/api','')
        //},
        onProxyReq: (proxyReq, req, res)=> {
          console.log(`代理${req.host}${req.path}到${proxyReq.getHeader('host')}${proxyReq.path}`)
        }
      }
    }
  },
  publicPath: config.Client.webpack.publicPath,
  configureWebpack:{
    resolve: {
      alias: {
        '@docs': path.resolve('./pages/index/MDdocs'),
      }
    },
    module: {
      rules: [{
          test: /\.md$/,
          loader: 'raw-loader'
      }]
    }
  }
}