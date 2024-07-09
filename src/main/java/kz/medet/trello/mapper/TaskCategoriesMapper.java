package kz.medet.trello.mapper;

import kz.medet.trello.dtos.TaskCategoriesDto;
import kz.medet.trello.model.TaskCategories;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskCategoriesMapper {
    TaskCategoriesDto toTaskCategoriesDto(TaskCategories taskCategories);

    TaskCategories toTaskCategories(TaskCategoriesDto taskCategoriesDto);

    List<TaskCategoriesDto> toTaskCategoriesDtoList(List<TaskCategories> taskCategories);
}
