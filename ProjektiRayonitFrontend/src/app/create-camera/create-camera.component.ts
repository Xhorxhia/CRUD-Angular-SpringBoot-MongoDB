import { Component, OnInit } from '@angular/core';
import { Camera } from '../camera';
import { CameraService } from '../camera.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-camera',
  templateUrl: './create-camera.component.html',
  styleUrls: ['./create-camera.component.css']
})
export class CreateCameraComponent implements OnInit {

  camera: Camera = new Camera();
  submitted = false;

  constructor(private cameraService: CameraService, private router: Router) { }

  ngOnInit(): void {
  }

  newCamera(): void{
    this.submitted = false;
    this.camera= new Camera();
  }

  save(){
    this.cameraService
    .createCamera(this.camera).subscribe(data => {
      console.log(data)
      this.camera = new Camera();
      this.goToList();
    },
    error => console.log(error));
  }

  onSubmit(){
    this.submitted =true;
    this.save();
  }

  goToList(){
    this.router.navigate(['/camerasAll']);
  }
}
