import {Component, Input, OnInit} from '@angular/core';
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {finalize} from "rxjs";

@Component({
    selector: 'app-upload-picture',
    templateUrl: './upload-picture.component.html',
    styleUrls: ['./upload-picture.component.sass']
})
export class UploadPictureComponent implements OnInit {
    selectedFile: File | null = null;
    @Input() userId: number | null = null;

    constructor(private storage: AngularFireStorage) {
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
    }
}
