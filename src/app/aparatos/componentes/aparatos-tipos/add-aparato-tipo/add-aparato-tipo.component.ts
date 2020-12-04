import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AparatoTipo } from 'src/app/modelos/aparato-tipo.model';
import { AparatosTiposService } from 'src/app/servicios/aparatos-tipos.service';

@Component({
  selector: 'app-add-aparato-tipo',
  templateUrl: './add-aparato-tipo.component.html',
  styleUrls: ['./add-aparato-tipo.component.css']
})
export class AddAparatoTipoComponent implements OnInit {

  // Variables
  public aparatoTipo: AparatoTipo = new AparatoTipo();
  public aparatoTipoForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _aparatosTipos: AparatosTiposService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.aparatoTipoForm = new FormGroup({
      nombre: new FormControl('', Validators.required)
    });
  }

  // Guardar Marca
  guardarAparatoMarca() {
    this.aparatoTipo = Object.assign({}, this.aparatoTipoForm.value);

    this._aparatosTipos.addAparatoTipo(this.aparatoTipo).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
