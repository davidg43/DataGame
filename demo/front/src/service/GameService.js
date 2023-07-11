import axios from "axios";

export default class GameService {

    url = "http://localhost:8080/games"
    index = "http://localhost:8080/index"

    getAll() {
        return axios.get(this.url);
    }

    getByPlatform(name) {
        return axios.get(this.url + "p?p=" + name);
    }

    getByName(name) {
        return axios.get(this.url + "t?t=" + name);
    }

    getByNameAndPlatform(name, platform) {
        return axios.get(this.url + "pt?p=" + platform + "&t=" + name);
    }

    updateIndex() {
        return axios.get(this.index);
    }
}