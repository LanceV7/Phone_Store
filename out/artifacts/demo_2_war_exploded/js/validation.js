function Validator (element, formatter, warning, errorMessage)
{
    this.x = element;
    this.format = formatter;
    this.warner = warning;
    this.error = errorMessage;

    this.verifier = function () {

        console.log (this.x.value);
        if (this.x.value.match (this.format))
        {
            this.warner.innerHTML = "";
            return true;
        }
        else
        {
            this.x.value = "";
            console.log ("hola");
            this.warner.innerHTML = this.error;
            return false;
        }
    }
}

function focuser (domElement)
{
    domElement.style.border = "2px solid blue";
    domElement.style.backgroundColor = "blue";
}

function blurer (domElement)
{
    domElement.style.border = "";
    domElement.style.backgroundColor = "";
}
