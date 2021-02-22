import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Camera } from './camera';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CameraService {

  private baseUrl = "http://localhost:8080/api/"

  constructor(private http: HttpClient) { }
  
  createCamera(camera: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + 'create', camera);  //  (+ 'create') shton api
  }

  getCameras(): Observable<Camera[]> {
    return this.http.get<Camera[]>(`${this.baseUrl}` + 'camerasAll');
  }

  deleteCamera(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + 'delete/' + `${id}`);  
  }

  // getResolutions(): Observable<any> {  // per chart  
  //   return this.http.get(`${this.baseUrl}` + 'chart') as Observable<any>;
  //} 

   getResolutions(): Observable<String[]> {  // per chart  
    return this.http.get<String[]>(`${this.baseUrl}` + 'chart');
  }

}
