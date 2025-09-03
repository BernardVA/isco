import { Component, OnInit } from '@angular/core';
import { ControlStrengthsService } from '../services/controlstrengths.service';
@Component({
  selector: 'app-isco-controls',
  templateUrl: './isco-controls.html',
  styleUrl: './isco-controls.css'
})
export class IscoControls implements OnInit {


  controlStrengths: any;
  controls: any;
  constructor(private controlStrengthsService: ControlStrengthsService) { }
  
  ngOnInit() {

    this.loadIscoData()
}

  loadIscoData() {
    this.controlStrengthsService.getControlStrengths().subscribe(
      (data) => {
        this.controlStrengths = data;
        console.log('Control Strengths:', this.controlStrengths);

      });
    this.controlStrengthsService.getControls().subscribe(
      (data2) => {
        this.controls = data2;
        console.log('Controls:', this.controls);

      });

  }
}