import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ControlStrengthsService {
  constructor(private http: HttpClient) { }

    getControlStrengths() {
        return this.http.get('http://localhost:8080/api/control-strengths');
    }

    getControls() {
        return this.http.get('http://localhost:8080/api/controls');
    }
} 
