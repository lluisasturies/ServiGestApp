import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AparatoMarca } from 'src/app/modelos/aparato-marca.model';
import { AparatoTipo } from 'src/app/modelos/aparato-tipo.model';
import { Aparato } from 'src/app/modelos/aparato.model';
import { AparatosMarcasService } from 'src/app/servicios/aparatos-marcas.service';
import { AparatosTiposService } from 'src/app/servicios/aparatos-tipos.service';
import { AparatosService } from 'src/app/servicios/aparatos.service';

@Component({
  selector: 'app-add-aparato',
  templateUrl: './add-aparato.component.html',
  styleUrls: ['./add-aparato.component.css']
})
export class AddAparatoComponent implements OnInit {

  // Variables
  public aparato: Aparato = new Aparato();
  public tipos: AparatoTipo[];
  public marcas: AparatoMarca[];
  public aparatoForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _aparatosTipos: AparatosTiposService,
    private _aparatosMarcas: AparatosMarcasService,
    private _aparatos: AparatosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.obtenerTipos();
    this.obtenerMarcas();

    // Creo el FormGroup
    this.aparatoForm = new FormGroup({
      tipo: new FormControl('', Validators.required),
      marca: new FormControl('', Validators.required),
      modelo: new FormControl('', Validators.required)
    });
  }

  // Obtener lista de Empresas
  obtenerTipos() {
    this._aparatosTipos.getTipos().subscribe(data => {
      this.tipos = data;
    });
  }

  // Obtener lista de Empresas
  obtenerMarcas() {
    this._aparatosMarcas.getMarcas().subscribe(data => {
      this.marcas = data;
    });
  }

  // Guardar Aparato
  guardarAparato() {
    this.aparato = Object.assign({}, this.aparatoForm.value);

    this._aparatos.addAparato(this.aparato).subscribe(data => { 
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
