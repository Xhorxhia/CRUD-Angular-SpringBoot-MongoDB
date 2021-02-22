import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CameraComponent } from './camera/camera.component';
import { CreateCameraComponent } from './create-camera/create-camera.component';
import { MyChartComponent } from './my-chart/my-chart.component';

const routes: Routes = [
  { path: '', redirectTo: 'camera', pathMatch: 'full' },
  { path: 'camerasAll', component: CameraComponent },
  { path: 'insert', component: CreateCameraComponent },
  { path: 'chart', component: MyChartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
