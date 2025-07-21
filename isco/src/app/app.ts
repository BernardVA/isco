import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RouterOutlet } from '@angular/router';



@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css',
  standalone: true
})

export class App implements OnInit {

  protected title = 'isco 5.4';
  controlStrengths = 'No data yett';
  constructor(private http: HttpClient) { }

  ngOnInit() {
    console.log('App component initialized BVV');
    this.controlStrengths = 'rzedrz'
    this.title = 'Hello, isco';
    this.http.get('http://localhost:8080/api/control-strengths', {observe: 'response'}).subscribe(data => {
      this.controlStrengths = JSON.stringify(data)  ;  
      this.controlStrengths = 'arrived here';    
       console.log('App component initialized VA');      
    });
    //  


  }
}
