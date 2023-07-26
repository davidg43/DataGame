import axios from "axios";

export default class GameService {

    url = "http://localhost:8080/games"
    index = "http://localhost:8080/index"

    getAll() {
        return fetch(this.url).then(response => response.json());
    }

    getByPlatform(name) {
        return axios.get(this.url + "p?p=" + name).then(response => response.data);
    }
    
    getByName(name) {
        return axios.get(this.url + "t?t=" + name).then(response => response.data);
    }

    getByNameAndPlatform(name, platform) {
        return axios.get(this.url + "pt?p=" + platform + "&t=" + name).then(response => response.data);
    }

    updateIndex() {
        return axios.get(this.index).then(response => response.data);
    }

    deleteGame(id) {
        return axios.delete("/delete/" + id).then(response => response.data);
    }

    updateGame(id) {
        return axios.put("/edit/" + id).then(response => response.data);
    }
    getById(id) {
        return axios.get("/game/" + id).then(response => response.data);
    }
}