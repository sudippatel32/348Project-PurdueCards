import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Card } from "./card";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class CardService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public getCards(): Observable<Card[]> {
        return this.http.get<Card[]>(`${this.apiServerUrl}/card/all`);
    }

    public addCard(card: Card): Observable<Card> {
        return this.http.post<Card>(`${this.apiServerUrl}/card/add`, card);
    }

    public updateCard(card: Card): Observable<Card> {
        return this.http.put<Card>(`${this.apiServerUrl}/card/update`, card);
    }

    public deleteCard(cardId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/card/delete/${cardId}`);
    }

}