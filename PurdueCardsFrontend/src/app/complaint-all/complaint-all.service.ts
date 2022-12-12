import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ComplaintAll } from "./complaint-all";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class ComplaintAllService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public getComplaints(): Observable<ComplaintAll[]> {
        return this.http.get<ComplaintAll[]>(`${this.apiServerUrl}/complaint/all`);
    }

}
