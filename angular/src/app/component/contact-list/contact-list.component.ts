import { Component, OnInit } from '@angular/core';
import { Contact } from '../../model/contact';
import { ContactService } from '../../service/contact.service';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {

  contacts: Contact[];
  ladyLogo: string;
  gentLogo: string;

  constructor(
    private contacService: ContactService
  ) {
    this.ladyLogo = '/assets/images/lady.png';
    this.gentLogo = '/assets/images/male.png';
  }

  ngOnInit() {
    this.contacService.getAllContacts().subscribe(
      (data) => this.contacts = data
    );
  }

}
