// All configuration item explanations can be find in https://cli.vuejs.org/config/
module.exports = {

    devServer: {
        open: false, //是否自动弹出浏览器页面
        host: "localhost",
        port: '8080',
        https: false,   //是否使用https协议
        hotOnly: true, //是否开启热更新
        proxy: {
            '/generator/api/v1': {
                target: 'http://47.103.192.205:10000/',
                changeOrigin: true,
                pathRewrite: {
                    '^generator/api/v1/': ''
                }
            }
        }
    },
    publicPath: './'
};