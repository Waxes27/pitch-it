import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class FormDataService {
  private formDataSet: any[] = [];
  private formData = new BehaviorSubject<any[]>(this.formDataSet);
  currentData = this.formData.asObservable();

  constructor() {}

  updateData(data: any) {
    this.formDataSet.push(data);

    this.formData.next(this.formDataSet);
  }
}
