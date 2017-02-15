var ResultsSingleListRowComponent = React.createClass({
  approve : function(){
    this.props.onHandleApprove(this.props.info.id,'single',this.props.info.name);
  },
  delete : function(){
    this.props.onHandleDelete(this.props.info.id,'single',this.props.info.name);
  },
  render: function() {
    console.log("bla bla bla: ", this.props.info);
    return (
      <tr>
        <td className="small">
          {this.props.info.name}
        </td>
        <td className="small">
          {this.props.info.representativeName}
        </td>
        <td className="small">
          {this.props.info.votesSingleRegisteredDate}
        </td>
        <td>
          <div>
              &nbsp;
              <button onClick={this.approve} ref="confirm" data-toggle="tooltip1" title="Patvirtinti" type="button" className="btn btn-success btn-sm fa fa-check"></button>
              &nbsp;
              <button onClick={this.delete} ref="delete" data-toggle="tooltip1" title="Ištrinti" type="button" className="btn btn-danger btn-sm fa fa-trash"></button>
          </div>
        </td>
      </tr>
    );
  }

});

window.ResultsSingleListRowComponent = ResultsSingleListRowComponent;
