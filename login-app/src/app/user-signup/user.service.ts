import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {User} from "./user.model";
import 'rxjs/add/operator/map';

@Injectable()
export class UserService{

  private resourceUrl = 'http://localhost:9000/user';

  constructor(private http: Http) {

  }

  create(user: User) {
    return this.http.post(this.resourceUrl, user).map((res) => res.json());
  }

  query() {
    return this.http.get(this.resourceUrl);
  }

  find(id: number) {
    return this.http.get(`${this.resourceUrl}/${id}`).map((res) => res.json());
  }

  update(user: User) {
    return this.http.put(this.resourceUrl, user);
  }

  delete(id: number) {
    return this.http.delete(`${this.resourceUrl}/${id}`);
  }

}
