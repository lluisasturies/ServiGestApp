import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AparatoMarca } from 'src/app/modelos/aparato-marca.model';
import { AparatosMarcasService } from 'src/app/servicios/aparatos-marcas.service';

@Component({
  selector: 'app-add-aparato-marca',
  templateUrl: './add-aparato-marca.component.html',
  styleUrls: ['./add-aparato-marca.component.css']
})
export class AddAparatoMarcaComponent implements OnInit {

  // Variables
  public aparatoMarca: AparatoMarca = new AparatoMarca();
  public aparatoMarcaForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _aparatosMarcas: AparatosMarcasService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.aparatoMarcaForm = new FormGroup({
      nombre: new FormControl('', Validators.required)
    });
  }

  // Guardar Marca
  guardarAparatoMarca() {
    this.aparatoMarca = Object.assign({}, this.aparatoMarcaForm.value);

    this._aparatosMarcas.addAparatoMarca(this.aparatoMarca).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
