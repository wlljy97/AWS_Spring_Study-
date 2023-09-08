import api from "./api"

export const registerUser = async (user) => {
    return api.post("/user", user);
}

export const getUserListAll = async () => {
    return api.get("/user/list");
}

export const updateUser = async (user) => {
    return api.put(`/users/${user.userId}`, user); // 몇번 user를 update 하기 위해 백쿼터 사용
}

export const deleteUser = async (userId) => {
    return api.delete(`/users/${userId}`);
}