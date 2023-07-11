import axios from "axios";

export default class UserService {

    register = "http://localhost:8080/register"
    login = "http://localhost:8080/login"

    registerUser(user) {
        return axios.post(this.register + "/save", user);
    }

    loginUser(user) {
        return axios.post(this.login, user);
    }
}