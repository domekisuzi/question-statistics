//made by @domekisuzi at 2024/7/10:19:32

// src/axios.js
import axios from 'axios';

const instance = axios.create({
    baseURL: '/api', // 根据实际情况修改后端服务器的地址
    timeout: 1000,
    withCredentials: true,  // 允许跨域请求携带 Cookie
});


export default  instance ;
