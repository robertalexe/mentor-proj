import { FormGroup, FormControl } from '@angular/forms';
import { User } from './user.model'

export class UserForm extends FormGroup {

    constructor(user?: User) {
        super( {
            email: new FormControl(user? user.id : ''),
            contactNo: new FormControl(user? user.contactNumber:  ''),
            username: new FormControl(user? user.userName : ''),
            password: new FormControl(user? user.password : ''),
            firstName: new FormControl(user? user.firstName : ''),
            lastName: new FormControl(user? user.lastName : '')
        }
        );
    }
}