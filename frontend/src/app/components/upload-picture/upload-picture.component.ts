import {Component, Input, OnInit} from '@angular/core';
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {finalize} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {CookieService} from "ngx-cookie-service";

@Component({
    selector: 'app-upload-picture',
    templateUrl: './upload-picture.component.html',
    styleUrls: ['./upload-picture.component.sass']
})
export class UploadPictureComponent implements OnInit {
    selectedFile: File | null = null;
    @Input() userId: number | null = null;

    constructor(private storage: AngularFireStorage, private http: HttpClient, private cookies: CookieService) {
    }

    ngOnInit(): void {
    }

    onFileSelected(event: any) {
        this.selectedFile = event.target.files[0];
        console.log(this.selectedFile?.name)
    }

    uploadFile() {
        const filePath = `user/profile-pics/${this.userId}.png`;

        // Create a reference to the file path in Firebase Storage
        const fileRef = this.storage.ref(filePath);

        // Upload the file to Firebase Storage and get the upload task
        const uploadTask = fileRef.put(this.selectedFile);


        uploadTask.percentageChanges().subscribe(progress => {
            console.log(`Upload is ${progress}% done`);
        });

        uploadTask.snapshotChanges().pipe(
            finalize(() => {
                fileRef.getDownloadURL().subscribe(url => {
                    console.log('File uploaded to:', url);
                });
            })
        ).subscribe();

        fileRef.getDownloadURL().subscribe(url => {
            let newUrl = url
            let body = {
                "pictureUrl": newUrl
            }

            this.http.post(`http://pitchitltd.co.uk:8081/profile?email=${this.cookies.get('userEmail')}`, 
            {
                withCredentials: true,
                "pictureUrl" : newUrl,
            }
            ).subscribe(data => {
                console.log(data)
            })
        })
    }
}
