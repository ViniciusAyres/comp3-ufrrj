package dados.datamappers.interfaces;

public interface StringDataMapper extends DataMapper {
    Object buscarPorMatricula(String matricula);
}
