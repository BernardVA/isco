import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableListService } from '../services/table-list.service';
@Component({
  selector: 'app-isco-controls',
  templateUrl: './isco-controls.html',
  styleUrl: './isco-controls.css',
  imports: [CommonModule]
})
export class IscoControls implements OnInit {


  controlStrengths: any;
  control_implementations: any;
  threatEvents: any;
  
  constructor(private tableListService: TableListService) { }
  
  ngOnInit() {

    this.loadIscoData()
}
// Method to load data, defined in controls.service.ts
  loadIscoData() {
    this.tableListService.getControlStrengths().subscribe(
      (data) => {
        this.controlStrengths = data;
        console.log('Control Strengths:', this.controlStrengths);

      });
    this.tableListService.getControl_implementations().subscribe(
      (data2) => {
        this.control_implementations = data2;
        console.log('Control implementations:', this.control_implementations);

      });
this.tableListService.getThreatEvents().subscribe(
      (data3) => {
        this.threatEvents = data3;
        console.log('Threat events:', this.threatEvents);
      });
  }
}