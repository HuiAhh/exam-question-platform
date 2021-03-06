module.exports = {
    outputDir: 'dist',   //build输出目录
    assetsDir: 'assets', //静态资源目录（js, css, img）
    lintOnSave: true, //是否开启eslint
    devServer: {
        open: false, //是否自动弹出浏览器页面
        host: "localhost",
        port: '8080',
        https: false,   //是否使用https协议
        hotOnly: true, //是否开启热更新
        proxy: {
            '/generator/api/v1':{
                target:'http://localhost:9999/',
                changeOrigin:true,
                pathRewrite:{
                    '^generator/api/v1/':''
                }
            }
        }
    },
    publicPath:'./',

}