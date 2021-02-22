import { Component, OnInit } from '@angular/core';
import { Camera } from '../camera';
import { CameraService } from '../camera.service';
import { Observable } from "rxjs";

@Component({
  selector: 'app-camera',
  templateUrl: './camera.component.html',
  styleUrls: ['./camera.component.css']
})
export class CameraComponent implements OnInit {

  cameras:  Observable<Camera[]>;
  camerasAll: Camera[];
  

  constructor(private cameraService: CameraService) {

  }

    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
     // this.cameras = this.cameraService.getCameras();
     this.cameraService.getCameras().subscribe((data: Camera[]) =>{
        console.log(data); 
        this.camerasAll = data;
      });
    }

    // deleteCamera(id: number) {
    //   this.cameraService.deleteCamera(id)
    //     .subscribe(
    //       (data)=> {  
    //         console.log(data);
    //         this.reloadData();
    //       },
    //       error => console.log(error));
    // }

    deleteCamera(id: number): void {
      this.cameraService.deleteCamera(id).subscribe();
      this.reloadData();
    }
  }
