import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Subscription } from 'rxjs';
import { Departman } from 'src/app/models/departman';
import { Student } from 'src/app/models/student';
import { StatusService } from 'src/app/services/status.service';
import { StudentService } from 'src/app/services/student.service';
import { DepartmanService } from 'src/app/services/departman.service';
import { Status } from 'src/app/models/status';



@Component({
  selector: 'app-student-dialog',
  templateUrl: './student-dialog.component.html',
  styleUrls: ['./student-dialog.component.css']
})
export class StudentDialogComponent implements OnInit {

  departman: Departman[];
  status: Status[];
  public flag: number;
  departmanSubscription: Subscription;
  statusSubscription: Subscription;

  constructor(public snackBar: MatSnackBar,
              public dialogRef: MatDialogRef<StudentDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Student,
              public studentService: StudentService,
              public departmanService: DepartmanService,
              public statusService:StatusService) { }

  ngOnInit(): void {
    this.departmanSubscription = this.departmanService.getAllDepartman()
      .subscribe(data => {
        this.departman = data;
      }), (error:Error) => {
        console.log(error.name + ' ' + error.message)
      }
      this.statusSubscription = this.statusService.getAllStatus()
        .subscribe(data => {
          this.status = data;
        }),(error:Error) => {
          console.log(error.name + ' ' + error.message)
        }
  }

  ngOnDestroy() {
    this.departmanSubscription.unsubscribe();
    this.statusSubscription.unsubscribe();
  }

  compareTo(a: any, b: any) {
    return a.id === b.id
  }

  public add(): void {
    this.studentService.addStudent(this.data)
      .subscribe(() => {
        this.snackBar.open('Uspešno dodat student!', 'U redu', {
          duration: 2500
        })
      }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Dogodila se greška!', 'Zatvori', {
          duration: 1500
        })
      };
  }

  public update(): void {
    this.studentService.updateStudent(this.data)
    .subscribe(() => {
      this.snackBar.open('Uspešno dodat student!', 'U redu', {
        duration: 2500
      })
    }),
    (error: Error) => {
      console.log(error.name + ' ' + error.message);
      this.snackBar.open('Dogodila se greška!', 'Zatvori', {
        duration: 1500
      })
    };
  }

  public delete(): void {
    this.studentService.deleteStudent(this.data.id)
    .subscribe(() => {
      this.snackBar.open('Uspešno obrisan student!', 'U redu', {
        duration: 2500
      })
    }),
    (error: Error) => {
      console.log(error.name + ' ' + error.message);
      this.snackBar.open('Dogodila se greška!', 'Zatvori', {
        duration: 1500
      })
    };
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste!', 'Zatvori', {
      duration: 1500
    })
  }

}
