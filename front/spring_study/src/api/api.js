import axios from "axios"

const api = axios.create({
    baseURL: "http://localhost:8080" // axios안에 create가 있는데 무조건 들어가는 공통으로 들어가는 파라미터들을 넣어 놓는다.
});

export default api;