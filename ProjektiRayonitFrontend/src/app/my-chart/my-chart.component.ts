import { Component, OnInit } from '@angular/core';
import { Chart } from 'node_modules/chart.js';
import { Camera } from '../camera';
import { CameraService } from '../camera.service';
import { Observable } from "rxjs";

@Component({
    selector: 'app-my-chart',
    templateUrl: './my-chart.component.html',
    styleUrls: ['./my-chart.component.css']
})

export class MyChartComponent implements OnInit {

    cameras: Observable<Camera[]>;
    camerasAll: Camera[];

    constructor(private cameraService: CameraService) { }

    ngOnInit() {
        this.reloadData();
    }

    reloadData() {
        // this.cameras = this.cameraService.getCameras();
        this.cameraService.getResolutions().subscribe((data) => {
            console.log(data);
            var myChart = new Chart("myChart", {  // name of the canvas element from my-chart.component
                type: 'bar',
                data: {
                    labels: ['Camera 1', 'Camera 2', 'Camera 3', 'Camera 4', 'Camera 5'],
                    datasets: [{
                        label: 'Resolution',
                        data: data, 
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        });
    }

    //   ngOnInit(): void {
    //       //console.log(this.cameraService.getResolutions());

    //   }

}
