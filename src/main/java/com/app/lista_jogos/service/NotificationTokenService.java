package com.app.lista_jogos.service;

import java.util.Optional;

import com.app.lista_jogos.handler.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lista_jogos.dto.NotificationTokenDTO;
import com.app.lista_jogos.entity.NotificationTokenEntity;
import com.app.lista_jogos.entity.UserEntity;
import com.app.lista_jogos.repository.NotificationTokenRepository;
import com.app.lista_jogos.repository.UserRepository;

@Service
public class NotificationTokenService {

    @Autowired
    private NotificationTokenRepository notificationTokenRepository;
    @Autowired
    private UserRepository userRepository;


    public void saveNotificationToken(NotificationTokenDTO notificationTokenDTO) {
        NotificationTokenEntity notificationTokenNew = new NotificationTokenEntity(notificationTokenDTO);

        Optional<UserEntity> userEntity = userRepository.findByUsername(notificationTokenDTO.getUsername());
        if(userEntity.isEmpty()){
            throw new BusinessException("Usuario não encontrado");
        }
        Optional<NotificationTokenEntity> notificationTokenOld = notificationTokenRepository.findByUserEntity(userEntity.get());
        if (notificationTokenOld.isPresent()){

            NotificationTokenEntity notificationToken = notificationTokenOld.get();
            notificationToken.setToken(notificationTokenDTO.getToken());
            notificationTokenRepository.save(notificationToken);

        } else {
            notificationTokenNew .setUserEntity(userEntity.get());
            notificationTokenRepository.save(notificationTokenNew);

        }
    }

}
