import {Role} from "../enum/role.enum";

/**
 * Created by kamil on 26/02/2018.
 */

export class User {
  id: number;
  email: string;
  roles: Role[];
}
