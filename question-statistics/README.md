踩坑日记


server: {
proxy: {
'/api': {
target: 'http://localhost:8080',
changeOrigin: true,
rewrite: (path) => path.replace(/^\/api/, ''),
},
},
},
配置错误，导致直接api直接全部404 
