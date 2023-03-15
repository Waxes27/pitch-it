import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-appointment-booking',
  templateUrl: './appointment-booking.component.html',
  styleUrls: ['./appointment-booking.component.sass']
})
export class AppointmentBookingComponent implements OnInit {
bookingForm = new FormGroup({
  name: new FormControl('', [<any>Validators.required, <any>Validators.minLength(6)]),
  email: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
  number: new FormControl('', [<any>Validators.required, <any>Validators.minLength(8)]),
});
onSubmit() {
  
}

  constructor() { }

  ngOnInit(): void {
  }

}
