export class User {
  public id?: number;
  public username?: string;
  public password?: string;
  private email ?: string;
  private enable ?: boolean

  constructor(id?: number,
              username?: string,
              password?: string,
              email?: string,
              enable?:boolean
              ) {
    this.id = id ? id : null;
    this.username = username ? username : null;
    this.password = password ? password : null;
    this.email = email ? email : null;
    this.enable = enable ? enable : null;
  }
}
