import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule }from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCameraComponent } from './create-camera/create-camera.component';
import { CameraComponent } from './camera/camera.component';
import { CameraService } from './camera.service';
import { MyChartComponent } from './my-chart/my-chart.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateCameraComponent,
    CameraComponent,
    MyChartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule,
    // ReactiveFormsModule
  ],
  providers: [CameraService], //shtim CameraService
  bootstrap: [AppComponent]
})
export class AppModule { }
