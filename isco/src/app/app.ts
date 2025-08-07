import { Component, Injectable, OnInit } from '@angular/core';

import { ControlStrengthsService } from './services/controlstrengths.service';

import { RouterOutlet } from '@angular/router';




@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: 'app.html',
  styleUrl: './app.css',
  standalone: true
})

export class App implements OnInit {

  protected title = 'isco 5.4';
  controlStrengths: any;
  controls: any;
  constructor(private controlStrengthsService: ControlStrengthsService) { }

  ngOnInit() {

    this.title = 'Hello, isco Hier';
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
