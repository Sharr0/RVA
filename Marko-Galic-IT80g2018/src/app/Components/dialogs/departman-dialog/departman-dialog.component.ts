import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Subscription } from 'rxjs';
import { Departman } from 'src/app/models/departman';
import { Fakultet } from 'src/app/models/fakultet';
import { DepartmanService } from 'src/app/services/departman.service';
import { FakultetService } from 'src/app/services/fakultet.service';

@Component({
  selector: 'app-departman-dialog',
  templateUrl: './departman-dialog.component.html',
  styleUrls: ['./departman-dialog.component.css']
})
export class DepartmanDialogComponent implements OnInit, OnDestroy {

fakultet: Fakultet[];
public flag: number;
fakultetSubsription: Subscription;

  constructor(public snackBar: MatSnackBar,
              public dialogRef: MatDialogRef<DepartmanDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Departman,
              public departmanService: DepartmanService,
              public fakultetService: FakultetService) { }

  ngOnInit(): void {
    this.fakultetSubsription = this.fakultetService.getAllFakultets()
      .subscribe(fakultet => {
        this.fakultet = fakultet
      })
  }

  ngOnDestroy(): void {
    this.fakultetSubsription.unsubscribe();
  }

  compareTo(a: any, b:any) {
    return a.id == b.id;
  }


  public add(): void {
    this.departmanService.addDepartman(this.data)
      .subscribe(() => {
        this.snackBar.open('Uspesno dodat departman: ', "U redu", {
          duration: 2500
          })
      }),
      (error: Error) => {
        console.log(error.name + '-->' + error.message);
        this.snackBar.open('Dogodila se greska. Pokusajte ponovo!', 'Zatvori', {
          duration: 2500
          });
      };
  }

  public update(): void {
    this.departmanService.updateDepartman(this.data)
    .subscribe(data => {
      this.snackBar.open('Uspesno modifikovan departman: ' + this.data.naziv, 'U redu', {
        duration: 2500
        });
    }),
    (error: Error) => {
      console.log(error.name + '-->' + error.message);
      this.snackBar.open('Dogodila se greska. Pokusajte ponovo!', 'Zatvori', {
        duration: 2500
        });
    }
  }

  public delete(): void {
    this.departmanService.deleteDepartman(this.data.id)
    .subscribe(data => {
      this.snackBar.open('Uspesno obrisan departman: ' + this.data.id, 'U redu', {
        duration: 2500
        });
    }),
    (error: Error) => {
      console.log(error.name + '-->' + error.message);
      this.snackBar.open('Dogodila se greska. Pokusajte ponovo!', 'Zatvori', {
        duration: 2500
        });
    }
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste', 'Zatvori', {
      duration: 2500
    });
  }


}
function ngOnDestroy(): ((error: any) => void) | null | undefined {
  throw new Error('Function not implemented.');
}

