package be.he2b.scrum.business;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.he2b.scrum.DTOS.ProjectDTO;
import be.he2b.scrum.repository.StoryRepository;

@Service
public class ScrumService {

    @Autowired
    private StoryRepository storyRepository;

    public Collection<ProjectDTO> getProjectsStartingWith(String projectNamePrefix) {
        return storyRepository.findProjectWithNameBegin(projectNamePrefix);
    }
}
