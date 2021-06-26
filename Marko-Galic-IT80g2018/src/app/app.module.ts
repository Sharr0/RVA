import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HomeComponent } from './Components/core/home/home.component';
import { AuthorComponent } from './Components/core/author/author.component';
import { AboutComponent } from './Components/core/about/about.component';
import { FakultetComponent } from './Components/fakultet/fakultet.component';
import { DepartmanComponent } from './Components/departman/departman.component';
import { StudentComponent } from './Components/student/student.component';
import { StatusComponent } from './Components/status/status.component';
import { FakultetDialogComponent } from './Components/dialogs/fakultet-dialog/fakultet-dialog.component';
import { StatusDialogComponent } from './Components/dialogs/status-dialog/status-dialog.component';
import { DepartmanDialogComponent } from './Components/dialogs/departman-dialog/departman-dialog.component';
import { StudentDialogComponent } from './Components/dialogs/student-dialog/student-dialog.component';

import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AuthorComponent,
    AboutComponent,
    FakultetComponent,
    DepartmanComponent,
    StudentComponent,
    StatusComponent,
    FakultetDialogComponent,
    StatusDialogComponent,
    DepartmanDialogComponent,
    StudentDialogComponent,

    ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatGridListModule,
    MatExpansionModule,
    MatTableModule,
    HttpClientModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatDialogModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    MatCheckboxModule,
    MatSelectModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
