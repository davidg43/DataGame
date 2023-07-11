import axios from "axios";

export default class LibraryService {

    library = "http://localhost:8080/library"
    
    addGame(game) {
        return axios.post(this.library + "/add", game);
    }
    deleteGame(game) {      
        return axios.delete(this.library + "/delete", game);
    }
    getById(id) {   
        return axios.get(this.library + "/id?id=" + id);
    }
}