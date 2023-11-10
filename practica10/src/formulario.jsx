import { Button, TextField, Box} from "@mui/material"
import { useState } from "react"
import axios from "axios"
function Formulario(props) {
    const [Cargando,setCargando]=useState(false)
    const [datosFormulario, setDatosFormulario]=useState(
        {nombre:'',
        password:''})
    
    const hacerPeticion = async () => {
        try{
            const response = await axios.get('http://localhost:5173/1')
            return response.data
            console.log(response.data)
        } catch(error){
            throw error
        }
    }

    const procesarFormulario = async (evento) =>{
        evento.preventDefault()
        console.log("datos recuperados del formulario:", datosFormulario)
        setCargando(true)

        try{
            const response = await hacerPeticion()
            setCargando(false)
            if(datosFormulario.nombre === response.username){
                console.log("El usuario existe")
            }else{
                console.log("Error, el usuario no existe")
            }
        }catch(error){
            console.log("error",error)
            setCargando(false)
        }
    }

    const cambiosFormulario = (evento) =>{
        const{name,value} = evento.target 
        setDatosFormulario ({
            ...datosFormulario,
            [name]: value
        })
    }

    return(
            <>
                <form onSubmit={procesarFormulario}>
                    <h1>Inicio de sesion</h1>
                    <Box m={5}>
                    <TextField label="nombre: " variant="outlined"  onChange={cambiosFormulario} name = "nombre" value={datosFormulario.nombre} fullWidth></TextField>
                    </Box>
                    <Box m={5}>
                    <TextField label="contraseña" variant="outlined"  onChange={cambiosFormulario} name = "password" value={datosFormulario.password} fullWidth></TextField>
                    </Box>
                    <Box m={5}>
                    <Button variant="contained" type="submit" color="primary" fullWidth >Iniciar sesion</Button>
                    </Box>
                </form>
            </>
    )
        
    
}

export default Formulario