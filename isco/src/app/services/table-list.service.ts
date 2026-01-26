import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class TableListService {
  constructor(private http: HttpClient) { }

    getControlStrengths() {
        return this.http.get('http://localhost:8080/api/control-strengths');
    }

    getControl_implementations() {
        return this.http.get('http://localhost:8080/api/control_implementations');
    }
getThreatEvents() {
        return this.http.get('http://localhost:8080/api/threat-events');
    }

    
} 
