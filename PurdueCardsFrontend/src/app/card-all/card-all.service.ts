import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { CardAll } from "./card-all";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class CardAllService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public getCards(): Observable<CardAll[]> {
        return this.http.get<CardAll[]>(`${this.apiServerUrl}/card/all`);
    }


}
