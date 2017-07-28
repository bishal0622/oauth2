export class User {
  public id?: number;
  public username?: string;
  public password?: string;

  constructor(id?: number,
              username?: string,
              password?: string
              ) {
    this.id = id ? id : null;
    this.username = username ? username : null;
    this.password = password ? password : null;
  }
}
