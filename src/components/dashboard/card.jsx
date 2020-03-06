import React from "react";
import "../../bootstrap.css";
import "../../index.css";

function Card(props){
  return(
      <div className="container">
              <div className="card">
              <div className="card-body">
                <h5 className="card-title">{props.cardHeader}</h5>
                <p className="card-text">
                  <h6>{props.cardTitle}</h6>
                  {props.cardDesc}
                </p>
                <a href={props.url} class="btn btn-primary">{props.cardBtn}</a>
                </div>
              </div>
            </div>
  );
}

export default Card;