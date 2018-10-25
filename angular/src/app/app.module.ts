import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';
import { HttpModule} from '@angular/http';

import { AppComponent } from './app.component';
import { ContactListComponent } from './component/contact-list/contact-list.component';
import { ContactDetailsComponent } from './component/contact-details/contact-details.component';
import { ContactFormComponent } from './component/contact-form/contact-form.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { GenderCountPipe } from './pipe/gender-count.pipe';


const paths: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: 'listContacts',
    component: ContactListComponent
  },
  {
    path: 'addContact',
    component: ContactFormComponent
  },
  {
    path: 'editContact/:id',
    component: ContactFormComponent
  },
  {
    path: 'viewContact/:id',
    component: ContactDetailsComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ContactListComponent,
    ContactDetailsComponent,
    ContactFormComponent,
    DashboardComponent,
    GenderCountPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
