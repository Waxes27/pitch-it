import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
    selector: 'app-pitch',
    templateUrl: './pitch.component.html',
    styleUrls: ['./pitch.component.sass']
})
export class PitchComponent implements OnInit {
    @Input() title: string = '';
    @Input() body: string = '';
    @Input() id: number = 0;


    constructor(private http: HttpClient) {
    }

    ngOnInit(): void {
    }


}
